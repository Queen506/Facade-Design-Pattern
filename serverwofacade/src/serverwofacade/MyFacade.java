/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverwofacade;

/**
 *
 * @author ntpsm
 */
public class MyFacade {
    private static MyFacade MyFacadeObj = null;
    private MyFacade(){}
    public static MyFacade getMyFacadeObject(){
        if(MyFacadeObj == null) {
            MyFacadeObj = new MyFacade();
        }
        return MyFacadeObj;
    }
    
    public void start(){
        ScheduleServer s = new ScheduleServer();
        s.startBooting();
        s.readSystemConfigFile();
        s.init();
        s.initializeContext();
        s.initializeListeners();
        s.createSystemObjects();
                                   
    }
    public void stop(){
        ScheduleServer s = new ScheduleServer();
        s.releaseProcesses();
        s.destory();
        s.destroySystemObjects();
        s.destoryListeners();
        s.destoryContext();
        s.shutdown();
                                   
    }
}
