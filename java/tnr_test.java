import dev._2lstudios.tor_nodes_resolver.TorNodesResolver;

public class tnr_test {

    public static void main (String[] args) {
        TorNodesResolver tnr = new TorNodesResolver();

        System.out.println(tnr.isNode("45.154.35.252"));
        System.out.println(tnr.isNode("11.22.33.44"));
    }   

}