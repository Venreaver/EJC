package add_03;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // CollisionCat has hash = 1, so all elements with type CollisionCat
        // will be put in one bucket
        Map<CollisionCat, CollisionCat> collisionCatMap = new HashMap<>();
        CollisionCat barsik = new CollisionCat("Barsik");
        CollisionCat murzik = new CollisionCat("Murzik");
        CollisionCat dymok = new CollisionCat("Dymok");
        CollisionCat snezhok = new CollisionCat("Snezhok");
        CollisionCat riska = new CollisionCat("Riska");
        CollisionCat levchik = new CollisionCat("Levchik");
        collisionCatMap.put(barsik, barsik);
        collisionCatMap.put(murzik, murzik);
        collisionCatMap.put(dymok, dymok);
        collisionCatMap.put(snezhok, snezhok);
        collisionCatMap.put(riska, riska);
        collisionCatMap.put(levchik, levchik);
        System.out.println(collisionCatMap);

        // LostCat hashCode depends on String name
        // if we change name, we change hashCode of object
        // and we lose this object in HashMap
        Map<LostCat, LostCat> lostCatMap = new HashMap<>();
        LostCat barsi = new LostCat("Barsik");
        LostCat murzi = new LostCat("Murzik");
        LostCat dymo = new LostCat("Dymok");
        LostCat snezho = new LostCat("Snezhok");
        LostCat risk = new LostCat("Riska");
        LostCat levchi = new LostCat("Levchik");
        lostCatMap.put(barsi, barsi);
        lostCatMap.put(murzi, murzi);
        lostCatMap.put(dymo, dymo);
        lostCatMap.put(snezho, snezho);
        lostCatMap.put(risk, risk);
        lostCatMap.put(levchi, levchi);
        System.out.println(lostCatMap);
        System.out.println(lostCatMap.get(dymo));
        dymo.setName("Dimok");
        System.out.println(lostCatMap);
        System.out.println(lostCatMap.get(dymo));

        // if we copy map with lost element to another HashMap
        // lost element won't be lost in new HashMap
        Map<LostCat, LostCat> newLostCatMap = new HashMap<>(lostCatMap);
        // we can use another constructions to copy HashMap
        // Map<LostCat, LostCat> newLostCatMap = new HashMap<>();
        // newLostCatMap.putAll(lostCatMap);
        System.out.println(newLostCatMap);
        System.out.println(newLostCatMap.get(dymo));
    }
}
