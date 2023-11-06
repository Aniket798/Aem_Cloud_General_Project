import $ from 'jquery'
import 'highlightjs-line-numbers.js'


declare const window: any
(function () {
    "use strict";
    function CodeBlock() {

        window.hljs.highlightAll()
        const selector = document.querySelectorAll('.cmp-codeblock-container')
        selector.forEach((block) => {
            const isLineNumbers = $(block).attr('data-show-line-numbers')
            const isCopyButton = $(block).attr('data-show-copy-btn')
            const codeElement = $(block).find('pre code.hljs')
            if (isLineNumbers === 'false') {
                codeElement.addClass('nohljsln')
            }
            if(isCopyButton === 'true'){
                $(block).find('.code-block-copy-btn').removeClass('hide')
            const copyButton = block.children[1]
            copyButton.addEventListener('click', function () {
                setTimeout(function () {
                    copyButton.textContent = 'Copied'
                }, 250)
                setTimeout(function () {
                    copyButton.textContent = 'Copy'
                }, 2500)
            })
        }
        else {
            $(block).find('.code-block-copy-btn').addClass('hide')
        }

        });
    
        window.hljs.initLineNumbersOnLoad();
        window.Clipboard
    }
    if (document.readyState !== "loading") {
        CodeBlock();
    } else {
        console.log("called code block")
        document.addEventListener("DOMContentLoaded", CodeBlock);
    }
}());
