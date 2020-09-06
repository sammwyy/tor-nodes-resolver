const TorNodesResolver = require("./");
const tnr = TorNodesResolver();

setTimeout(() => {
    console.log(tnr.isNode("45.154.35.252"));
    console.log(tnr.isNode("11.22.33.44"));
}, 500);
