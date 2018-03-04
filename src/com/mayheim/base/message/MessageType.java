package com.mayheim.base.message;

public enum MessageType {
    SOURCE_LINE,
    SYNTAX_ERROR,
    PARSER_SUMMARY,
    INTERPRETER_SUMMARY,
    COMPILER_SUMMARY,
    MISCELLANEOUS,
    TOKEN,
    FETCH,
    ASSIGN,
    BREAKPOINT,
    RUNTIME_ERROR,
    CALL,
    RETURN,
}
