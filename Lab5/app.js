const computeIsomorphisms = require('graph-isomorphisms');

const G = [[1, 2], [2, 3], [3, 1]];
// three isomorphims between G and itself
console.log(computeIsomorphisms(G, G).length === 3); //=> true

// G not isomorphic to H
const H = [[1, 2], [2, 1], [1, 3]];
console.log(computeIsomorphisms(G, H).length > 0); //=> false

// G is same graph as I, but with different node identifiers
const I = [[42, 666], [666, 1], [1, 42]];
console.log(computeIsomorphisms(G, I).length > 0); //=> true