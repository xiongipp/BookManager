package com.xxh.library.entity;

import lombok.Data;

@Data
public class ReaderBorrowInfo {
    String name;
    String locate;
    String readerType;
    int canBorrowNum;
    int canBorrowDay;
    int hasLearned;
    String msg;
}
