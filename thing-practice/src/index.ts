/**
 * This file is just a silly example to show everything working in the browser.
 * When you're ready to start on your site, clear the file. Happy hacking!
 **/

import { reactive } from '@thi.ng/rstream';
import { $compile } from '@thi.ng/rdom';
import { count, scan } from '@thi.ng/transducers';

const counter = reactive(0).transform(scan(count(100)));

$compile(
    [
        "div",
        {},
        [
            "h1",
            { 
                onclick: () => counter.next(0)
            },
            "Hello, World... ",
            counter
        ]
    ]
).mount(document.body)

// confetti.create(document.getElementById('canvas') as HTMLCanvasElement, {
//   resize: true,
//   useWorker: true,
// })({ particleCount: 200, spread: 200 });


