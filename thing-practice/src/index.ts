import { $compile } from "@thi.ng/rdom"

$compile(["div", {}, "hello"]).mount(document.getElementById("app")!);
