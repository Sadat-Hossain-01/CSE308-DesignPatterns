public interface Component {
    void showHierarchy(int depth);

    default void showHierarchy() {
        showHierarchy(0);
    }

    void showDetails();

    void removeChild(Component c);

    void delete(); // this will first delete all the children by calling recursiveDelete(), then delete itself by removing itself from its parent's children list

    void addChild(Component c);
}
