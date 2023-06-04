package io.xiaochangbai.sensitive.core.support.check.impl;

import io.xiaochangbai.sensitive.common.constant.enums.ValidModeEnum;
import io.xiaochangbai.sensitive.core.support.format.CharFormatChain;
import io.xiaochangbai.sensitive.core.api.IWordContext;
import io.xiaochangbai.sensitive.common.core.NodeTree;
import io.xiaochangbai.sensitive.core.support.check.ISensitiveCheck;
import io.xiaochangbai.sensitive.core.support.check.SensitiveCheckResult;
import io.xiaochangbai.sensitive.common.annotation.ThreadSafe;
import io.xiaochangbai.sensitive.common.instance.Instances;

/**
 * 敏感词监测实现
 * xiaochangbai
 *
 */
@ThreadSafe
public class SensitiveCheckWord implements ISensitiveCheck {

    @Override
    public SensitiveCheckResult sensitiveCheck(String txt, int beginIndex, ValidModeEnum validModeEnum, IWordContext context) {
        NodeTree nowNode = context.sensitiveWordInfo();

        // 记录敏感词的长度
        int lengthCount = 0;
        int actualLength = 0;

        for (int i = beginIndex; i < txt.length(); i++) {
            // 获取当前的node信息
            nowNode = getNowNode(nowNode, context, txt, i);

            if (null != nowNode) {
                lengthCount++;
                if (nowNode.isKeywordEnd()) {
                    // 只在匹配到结束的时候才记录长度，避免不完全匹配导致的问题。
                    // eg: 敏感词 敏感词xxx
                    // 如果是 【敏感词x】也会被匹配。
                    actualLength = lengthCount;

                    // 这里确实需要一种验证模式，主要是为了最大匹配从而达到最佳匹配的效果。
                    if (ValidModeEnum.FAIL_FAST.equals(validModeEnum)) {
                        break;
                    }
                }
            } else {
                // 直接跳出循环
                break;
            }
        }

        return SensitiveCheckResult.of(actualLength, SensitiveCheckWord.class);
    }
    /**
     * 获取当前的前缀树
     * @param nodeTree 原始的当前node
     * @param context 上下文
     * @param txt 文本信息
     * @param index 下标
     * @return 实际的当前 map
     *
     */
    private NodeTree getNowNode(NodeTree nodeTree,
                          final IWordContext context,
                          final String txt,
                          final int index) {
        char c = txt.charAt(index);
        char mappingChar = Instances.singleton(CharFormatChain.class).format(c, context);

        // 这里做一次重复词的处理
        NodeTree subNode = nodeTree.getSubNode(mappingChar);
        // 启用忽略重复&当前下标不是第一个
        if(context.ignoreRepeat()
            && index > 0) {
            char preChar = txt.charAt(index-1);
            char preMappingChar = Instances.singleton(CharFormatChain.class)
                    .format(preChar, context);

            // 返回父节点
            if(preMappingChar == mappingChar) {
                return nodeTree;
            }
        }

        return subNode;
    }

}
