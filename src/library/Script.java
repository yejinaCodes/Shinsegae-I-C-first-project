package library;

import common.Menu;

public class Script {

  StringBuilder script = new StringBuilder();

  private void print(){
    System.out.println(script);
    script.delete(0, script.length());
  }

  public void selectMenu(){
    script.append(Menu.STOCKREQUESTMENUSELECT.getDescription());
    print();
  }
  public void readStockRequest(){
    script.append(Menu.FINDCONDITION.getDescription());
    print();
  }
  public void readStockRequestStatus(){
    script.append(Menu.FINDSTATUSWMS.getDescription());
    print();
  }

  public void updateStockRequest(){
    script.append(Menu.UPDATESTATUS.getDescription());
    print();
  }
  public void cancelStockRequest(){
  }

}
