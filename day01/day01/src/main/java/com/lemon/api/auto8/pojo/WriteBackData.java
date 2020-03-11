package com.lemon.api.auto8.pojo;

/**
 * 回写数据对象
 */

public class WriteBackData {
    //因为在testcase中遍历回写数据，每一条测试用例都回写一次，造成了很大的读写资源开销
    //所以在回写excel之前，先将excel数据缓存到一个对象中，最后循环遍历该对象，一次写入就可以。
    //所以新建这个会写数据的类
    private String sheetName;
    private  String caseId;
    private String cellName;
    private  String result;

    public WriteBackData(String sheetName, String caseId, String cellName, String result) {
        this.sheetName = sheetName;
        this.caseId = caseId;
        this.cellName = cellName;
        this.result = result;
    }

    public WriteBackData() {
    }



    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getCellName() {
        return cellName;
    }

    public void setCellName(String cellName) {
        this.cellName = cellName;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }


}
