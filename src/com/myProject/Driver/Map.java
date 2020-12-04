package com.myProject.Driver;

import com.myProject.Location.*;
import com.myProject.Driver.Tree.Node;
import com.myProject.Location.locationStrategies.HumanKingdom;

enum LOCATION {
    KINGDOM,
    FOREST,
    ELFCITY,
    MOUNTAIN,
    SEA,
    DEMONKINGDOM
}

class Tree {
    static class Node {
        Location location;
        Node left, right;

        Node(Location location){
            this.location = location;
            left = null;
            right = null;
        }

        public Location getLocation() { return location; }

        @Override
        public String toString() {
            return location.toString();
        }
    }

    public void insert(Node node, Location location) {
        if(node.left == null) node.left = new Node(location);
        else node.right = new Node(location);
    }
}

public class Map {
    private Tree tree;
    private Node current;

    Map() {
        Location[] locations = new Location[] { new Location(new HumanKingdom()), new Forest(), new Forest(), new Forest(), new Forest(), new Forest() };
        this.tree = new Tree();

        Node l0 = new Node(locations[LOCATION.KINGDOM.ordinal()]);
        tree.insert(l0, locations[LOCATION.FOREST.ordinal()]);              // Level 1 [Nymphs]
        this.current = l0;                                                  // Level 1 [Nymphs]

        Node l1 = l0.left;
        tree.insert(l1, locations[LOCATION.SEA.ordinal()]);                 // Level 2 [1] - L [Sirens]
        tree.insert(l1, locations[LOCATION.MOUNTAIN.ordinal()]);            // Level 2 [2] - R [Dwarves]

        // ------------------------ Left Branch --------------------------
        Node l21 = l1.left;                                                 // Level 2 [1] - L [Sirens]
        tree.insert(l21, locations[LOCATION.FOREST.ordinal()]);             // Level 3 [1] - L [Pixies]

        Node l31 = l21.left;                                                // Level 3 [1] - L [Pixies]
        tree.insert(l31, locations[LOCATION.MOUNTAIN.ordinal()]);           // Level 4 [1] - L [Dwarves]
        tree.insert(l31, locations[LOCATION.ELFCITY.ordinal()]);            // Level 4 [2] - R [Elves]

        Node l41 = l31.left;                                                // Level 4 [1] - L [Dwarves]
        tree.insert(l41, locations[LOCATION.ELFCITY.ordinal()]);            // Level 5 [1] - L [Elves]

        Node l51 = l41.left;                                                // Level 5 [1] - L [Elves]
        tree.insert(l51, locations[LOCATION.DEMONKINGDOM.ordinal()]);       // Level 6 [1] - L [Validar]
        tree.insert(l51.left, locations[LOCATION.DEMONKINGDOM.ordinal()]);  // Level 7 [1] - L [Typhon]

        Node l42 = l31.right;                                               // Level 4 [2] - R [Elves]
        tree.insert(l42, locations[LOCATION.MOUNTAIN.ordinal()]);           // Level 5 [2] - L [Dwarves]

        Node l52 = l42.left;                                                // Level 5 [2] - L [Dwarves]
        tree.insert(l52, locations[LOCATION.DEMONKINGDOM.ordinal()]);       // Level 6 [2] - L [Validar]
        tree.insert(l52.left, locations[LOCATION.DEMONKINGDOM.ordinal()]);  // Level 7 [2] - L [Typhon]

        // ------------------------ Right Branch --------------------------
        Node l22 = l1.right;                                                // Level 2 [2] - R [Dwarves]
        tree.insert(l22, locations[LOCATION.FOREST.ordinal()]);             // Level 3 [2] - L [Pixies]
        tree.insert(l22, locations[LOCATION.ELFCITY.ordinal()]);            // Level 3 [3] - R [Elves]

        Node l32 = l22.left;                                                // Level 3 [2] - L [Pixies]
        tree.insert(l32, locations[LOCATION.ELFCITY.ordinal()]);            // Level 4 [3] - L [Elves]
        tree.insert(l32, locations[LOCATION.SEA.ordinal()]);                // Level 4 [4] - R [Sirens]

        Node l43 = l32.left;                                                // Level 4 [3] - L [Elves]
        tree.insert(l43, locations[LOCATION.SEA.ordinal()]);                // Level 5 [3] - L [Sirens]

        Node l53 = l43.left;                                                // Level 5 [3] - L [Sirens]
        tree.insert(l53, locations[LOCATION.DEMONKINGDOM.ordinal()]);       // Level 6 [3] - L [Validar]
        tree.insert(l53.left, locations[LOCATION.DEMONKINGDOM.ordinal()]);  // Level 7 [3] - L [Typhon]

        Node l44 = l32.right;                                               // Level 4 [4] - L [Sirens]
        tree.insert(l44, locations[LOCATION.ELFCITY.ordinal()]);            // Level 5 [4] - L [Elves]

        Node l54 = l44.left;                                                // Level 5 [4] - L [Elves]
        tree.insert(l54, locations[LOCATION.DEMONKINGDOM.ordinal()]);       // Level 6 [4] - L [Validar]
        tree.insert(l54.left, locations[LOCATION.DEMONKINGDOM.ordinal()]);  // Level 7 [4] - L [Typhon]


        Node l33 = l22.right;                                              // Level 3 [3] - R [Elves]
        tree.insert(l33, locations[LOCATION.SEA.ordinal()]);               // Level 4 [3] - L [Sirens]

        Node l45 = l33.left;                                                // Level 3 [3] - R [Sirens]
        tree.insert(l45, locations[LOCATION.FOREST.ordinal()]);             // Level 4 [3] - L [Pixies]

        Node l55 = l45.left;                                                // Level 5 [4] - L [Pixies]
        tree.insert(l55, locations[LOCATION.DEMONKINGDOM.ordinal()]);       // Level 6 [4] - L [Validar]
        tree.insert(l55.left, locations[LOCATION.DEMONKINGDOM.ordinal()]);  // Level 7 [4] - L [Typhon]
    }

    public Node getCurrent() { return current; }
    public Location getCurrentLocation() { return current.location; }
    public Location[] getNext() {
        if(current.right != null) return new Location[] { current.left.location, current.right.location };
        else if (current.left != null) return new Location[] { current.left.location };
        else return null;
    }

    public Location next(String pos) {
        if (pos.equals("right") && current.right != null)
            current = current.right;
        else if (current.left != null)
            current = current.left;
        return current.location;
    }
}


/*
Kingdom --
    Description - ...
    Talk to wizard - ...
    .... <- wizard's first line
    take amulet
    go next location
 */
/*
Forest (day) --
    Description - ...
    Talk to nymphs - ...
    .... <- nymphs first line
    start mission
    .... <- nymphs talk again (automatically)
    take sphere
    go next location
 */
