package com.gafur.junitdemo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

class ConditionalTest {

    @Test
    @Disabled("Don't run until Jira #123 is resolved")
    void basicTest(){
        // execute method & perform asserts
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testForWindowsOnly(){
        // execute method & perform asserts
    }

    @Test
    @EnabledOnOs(OS.MAC)
    void testForMacOnly(){
        // execute method & perform asserts
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    void testForLinuxOnly(){
        // execute method & perform asserts
    }

    @Test
    @EnabledOnOs({OS.MAC, OS.WINDOWS})
    void testForMacAndWindowsOnly(){
        // execute method & perform asserts
    }

    @Test
    @EnabledOnJre(JRE.JAVA_17)
    void testOnlyForJava17(){
        // execute method & perform asserts
    }

    @Test
    @EnabledOnJre(JRE.JAVA_11)
    void testOnlyForJava11(){
        // execute method & perform asserts
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_13, max = JRE.JAVA_18)
    void testOnlyForJavaRange(){
        // execute method & perform asserts
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_11)
    void testOnlyForJavaRangeMin(){
        // execute method & perform asserts
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "LUV2CODE_ENV", matches = "DEV")
    void testOnlyForDevEnvironment(){
        // execute method & perform asserts
    }

    @Test
    @EnabledIfSystemProperty(named = "LUV2CODE_SYS_PROP", matches = "CI_CD_DEPLOY")
    void testOnlyForSystemProperty(){
        // execute method & perform asserts
    }
}
