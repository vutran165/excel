package com.java.excel.dao;

public class FileRepository {
    private String filename;
    private String row;
    private String column;
    private String versionExcel;
    private byte[] file;

    public FileRepository() {
    }

    /**
     * @return the file
     */
    public byte[] getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(byte[] file) {
        this.file = file;
    }

    public FileRepository(String filename, String row, String column, String versionExcel) {
        this.filename = filename;
        this.row = row;
        this.column = column;
        this.versionExcel = versionExcel;
    }

    public String getFilename() {
        return this.filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getRow() {
        return this.row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getColumn() {
        return this.column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getVersionExcel() {
        return this.versionExcel;
    }

    public void setVersionExcel(String versionExcel) {
        this.versionExcel = versionExcel;
    }
    
}