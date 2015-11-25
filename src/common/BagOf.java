/*
 * 
 */
package common;

import java.util.List;

/**
 *
 * @author JasonRobinson
 */
public interface BagOf {
    public List getBag();
    public void setBag(List l);
    public Object removeItem(int index);
    public List getUseCounts();
    public int useItem(int index);
    public int addItem(Object o);
    public boolean addItem(Object o, int index);
    public void addItemToEnd(Object o);
    public Object removeLastItem();
    public Object removeFirstItem();
    public void randomizeTheBag();
    public boolean isInTheBag(Object o);
}
