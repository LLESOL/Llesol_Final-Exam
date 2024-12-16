import java.util.Stack;

public class CreatureSortingAnalysisandStack {

    //Class representing a Creature with its name and power level 
    static class Creature {
        String creature;
        int powerLevel;

        Creature(String creature, int powerLevel) {
            this.creature = creature;
            this.powerLevel = powerLevel;
        }

        @Override
        public String toString() {
            return creature + " - " + powerLevel;
        }
    }

    // Sort creatures in descending order using Bubble Sort
    public static void BubbleSortDescending(Creature[] creatures) {
        int n = creatures.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (creatures[j].powerLevel < creatures[j + 1].powerLevel) {
                    //  Swap creatures[j] and creatures[j + 1]
                    Creature temp = creatures[j];
                    creatures[j] = creatures[j + 1];
                    creatures[j + 1] = temp;
                }
            }
        }
    }

    // Sort creatures in ascending order using Selection Sort
    public static void selectionSortAscending(Creature[] creatures) {
        int n = creatures.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (creatures[j].powerLevel < creatures[minIndex].powerLevel) {
                    minIndex = j;
                }
            }
            // Swap creatures[i] and creatures[minIndex]
            Creature temp = creatures[minIndex];
            creatures[minIndex] = creatures[i];
            creatures[i] = temp;
        }
    }

    // Push sorted creatures onto a stack and pop them
    public static void useStack(Creature[] creatures) {
        Stack<Creature> stack = new Stack<>();

        // Push all creatures onto the stack
        for (Creature creature : creatures) {
            stack.push(creature);
        }

        // Pop and display each creature from the stack
        System.out.println("\n***Stack Implementation: Popping Creatures***");
        while (!stack.isEmpty()) {
            System.out.println("Popped: " + stack.pop());
        }
    }

    public static void main(String[] args) {
        // Create an array of creatures with their power levels
        Creature[] creatures = {
            new Creature( "Dragon", 95),
            new Creature("Griffin", 88),
            new Creature("Unicorn", 78),
            new Creature("Phoenix", 92),
            new Creature("Centaur", 85),
        };

        //Sort creatures in descending order (Bubble Sort)
        Creature[] bubbleSortedCreatures = creatures.clone();
        BubbleSortDescending(bubbleSortedCreatures);
        System.out.println("***Bubble Sort: Descending Order by Power Level***");
        for (Creature creature : bubbleSortedCreatures) {
            System.out.println(creature);
        }

        // Sort creatures in ascending order (Selection Sort)
        Creature[] selectionSortedCreatures = creatures.clone();
        selectionSortAscending(selectionSortedCreatures);
        System.out.println("\n***Selection Sort: Ascending Order by Power Level***");
        for (Creature creature : selectionSortedCreatures) {
            System.out.println(creature);
        }

        // Stack Implementation using Bubble Sort result
        useStack(selectionSortedCreatures);
    }
}