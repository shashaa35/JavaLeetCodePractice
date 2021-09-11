package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LockingTree {

    Map<Integer, List<Integer>> children = new HashMap();
    int[] lock;
    int[] parents;
    public LockingTree(int[] parent) {
        lock = new int[parent.length];
        Arrays.fill(lock, -1);

        parents = parent;

        for(int i=0;i<parent.length;i++) {
            children.put(i, new ArrayList<Integer>());
        }

        for(int i=1;i<parent.length;i++){
            int p = parent[i];
            int c = i;
            List<Integer> childs = children.get(p);
            childs.add(c);
            children.put(p, childs);
        }
    }

    public boolean lock(int num, int user) {
        if(lock[num] != -1)
            return false;
        lock[num] = user;
        return true;
    }

    public boolean unlock(int num, int user) {
        if(lock[num] != user)
            return false;
        lock[num] = -1;
        return true;
    }

    public boolean upgrade(int num, int user) {
        if(lock[num] == -1 && hasNoLockedParent(num) && hasAtleastOneLockChild(num)){
            lock[num] = user;
            unlockAllChildren(num);
            return true;
        } else{
            return false;
        }
    }

    boolean hasAtleastOneLockChild(int num) {
        if(children.get(num).size()>0) {
            List<Integer> childs = children.get(num);
            for(Integer child: childs) {
                if(lock[child] != -1 || hasAtleastOneLockChild(child))
                    return true;
            }
        }
        return false;
    }

    boolean hasNoLockedParent(int num) {
        num = parents[num];
        while(num!=-1 && parents[num] != -1) {
            if(lock[num] != -1)
                return false;
            num = parents[num];
        }
        return true;
    }

    void unlockAllChildren(int num) {
        if(children.get(num).size()>0) {
            List<Integer> childs = children.get(num);
            for(Integer child: childs) {
                lock[child] = -1;
                unlockAllChildren(child);
            }
        }
    }

    public static void main(String[] args) {
        int[] parent = new int[] {-1,0,8,0,7,4,2,3,3,1};
        LockingTree obj = new LockingTree(parent);
        System.out.println(obj.upgrade(8,39));
        System.out.println(obj.upgrade(5,28));
        System.out.println(obj.upgrade(6,33));
        System.out.println(obj.upgrade(9,24));

        System.out.println(obj.lock(5,22));

        System.out.println(obj.upgrade(1,3));

        System.out.println(obj.lock(5,20));

        System.out.println(obj.upgrade(0,38));

        System.out.println(obj.lock(5,14));
        System.out.println(obj.lock(6,34));
        System.out.println(obj.lock(6,28));

        System.out.println(obj.upgrade(3,23));
        System.out.println(obj.upgrade(4,45));
        System.out.println(obj.upgrade(8,7));
        System.out.println(obj.upgrade(2,18));

        System.out.println(obj.lock(8,39));

        System.out.println(obj.upgrade(8,39));

        System.out.println(obj.lock(8,39));

        System.out.println(obj.upgrade(8,39));

        System.out.println(obj.unlock(8,39));
    }
}
/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */