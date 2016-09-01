package com.hellpring.model;

import java.time.format.DateTimeFormatter;

public abstract class Model {

    protected final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
}
