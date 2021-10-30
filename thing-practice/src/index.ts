import {} from "@thi.ng/rstream";
import { $compile } from "@thi.ng/rdom";
import {} from "@thi.ng/parse";
import {} from "@thi.ng/transducers";

$compile(
    ["div", {}, ["h1", {}, "Hello, Youtube"]]
).mount(document.body)