//「スッキリわかるサーブレット＆JSP入門」P298のコード10-14、55行目～69行目参考

package model;

import java.util.List;

import beans.ReadingRecBean;

public class ReadingRecAddLogic {

  public void execute(ReadingRecBean readingRec, List<ReadingRecBean> readingRecList){
	  readingRecList.add(0, readingRec);
  }
}