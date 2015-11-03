package ch.k42.rand;

import com.google.common.collect.Lists;
import org.junit.Test;

/**
 * @author Thomas
 * @version radio-tower-plugin 03.11.2015.
 */
public class WeightedRandomTest {

    @Test
    public void testNext() throws Exception {
        WeightedRandom<String> rand = new WeightedRandom<>(Lists.newArrayList(new WeightedItem<>("A",3),new WeightedItem<>("B",6)));
        double aCnt = 0;
        double bCnt = 0;
        for(int i=0; i<1000;i++){
            String item = rand.next();
            switch (item){
                case "A":
                    aCnt++;
                case "B":
                    bCnt++;
            }
        }
        System.out.printf("A/B: %f\n", aCnt / bCnt);
    }
}