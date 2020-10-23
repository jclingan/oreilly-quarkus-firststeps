package org.acme;

import io.quarkus.arc.config.ConfigProperties;

import java.util.Optional;

@ConfigProperties(prefix = "unused")                    // (1)
public class UnusedConfigProperties {
    int number;                                         // (2)

    String string="Unused string";                      // (2)

    Optional<Boolean> flag;                             // (3)

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public boolean getFlag() {
        return flag.isEmpty() ? false : flag.get();
    }

    public void setFlag(Optional<Boolean> flag) {
        this.flag = flag;
    }
}

