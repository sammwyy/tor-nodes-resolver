package dev._2lstudios.tor_nodes_resolver;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TorNodesResolver {

    public List<String> nodes = new ArrayList<String>();

    public TorNodesResolver () {
        final String url = "https://check.torproject.org/torbulkexitlist";

        try {
            final String content = getNodeListFromUrl(url);
            final String[] list = content.split("\n");

            for (final String node : list) {
                nodes.add(node);
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    private static String getNodeListFromUrl(final String requestURL) throws IOException {
        try (Scanner scanner = new Scanner(new URL(requestURL).openStream(), StandardCharsets.UTF_8.toString())) {
            scanner.useDelimiter("\\A");
            return scanner.hasNext() ? scanner.next() : "";
        }
    }

    public boolean isNode(final String address) {
        return this.nodes.contains(address);
    }

    public boolean isNode(final InetSocketAddress socketAddress) {
        final String address = socketAddress.getAddress().toString();
        return this.nodes.contains(address);
    }

}
