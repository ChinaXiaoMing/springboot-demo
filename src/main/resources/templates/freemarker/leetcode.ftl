package com.opencode.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
* @Description ${num}.${description}
* @level ${level}
* @Date ${date}
* @Version 1.0
**/
public class Solution${num} {

    public ${return} ${methodName}(${param}) {
    <#if return == "boolean">
        return true;
    <#elseif return == "int">
        return 1;
    <#elseif return == "void">

    <#else>
        return null;
    </#if>
    }

    @Test
    public void ${methodName}Test() {
    <#if return == "boolean">
        boolean result = new ${className}().${methodName}();
        Assert.assertTrue(result);
    <#elseif return = "int">
        int result = new ${className}().${methodName}();
        Assert.assertEquals(1, result);
    <#else>
        Assert.assertEquals(1, 1);
    </#if>
    }

}