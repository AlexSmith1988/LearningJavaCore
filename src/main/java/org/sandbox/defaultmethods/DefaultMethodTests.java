package org.sandbox.defaultmethods;

/**
 * Created by AIKuznetsov on 17.05.2017.
 */
public class DefaultMethodTests {

    public static void main(String[] args) {
        System.out.println(new ClashVictim().doMe());
    }
}

interface WithDefault {
    default Number doMe() {
        return 10;
    }
}

interface WithSameDefault {
    default Number doMe() {
        return 15;
    }
}

abstract class WithClashingDoMe{
    // Class overrides interface default method
    public Integer doMe() {
        return 12;
    }
}

class ClashVictim extends WithClashingDoMe implements WithDefault/*, WithSameDefault This Would not comile as a real clash*/ {

}