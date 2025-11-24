package com.example.task05;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
public class MailService<T> implements Consumer<InfoKeeper<T>> {
    private final Map<String, List<T>> MailBox = new HashMap<String, List<T>>(){
        @Override
        public List<T> get(Object key) {
            List<T> list = super.get(key);
            return list != null ? list : new ArrayList<>();
        }
    };
    public Map<String, List<T>> getMailBox() {
        return MailBox;
    }
    @Override
    public void accept(InfoKeeper<T> tInfoKeeper) {
        if (MailBox.containsKey(tInfoKeeper.getTo())) {
            MailBox.get(tInfoKeeper.getTo()).add(tInfoKeeper.getContent());
        } else {
            ArrayList<T> arrayList = new ArrayList<>();
            arrayList.add(tInfoKeeper.getContent());
            MailBox.put(tInfoKeeper.getTo(), arrayList);
        }
    }
}
