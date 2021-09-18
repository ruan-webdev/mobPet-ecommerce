package controller.command;


import controller.facade.IFacade;
import controller.facade.impl.Facade;

public abstract class AbstractCommand implements ICommand{
    protected IFacade facade = new Facade();
}