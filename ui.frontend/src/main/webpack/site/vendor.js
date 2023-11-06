import $ from 'jquery'
import hljs from 'highlight.js'
import 'lazysizes'
import 'lazysizes/plugins/parent-fit/ls.parent-fit'
import ClipboardJS from 'clipboard'


window.$ = $
window.jquery = $
window.hljs = hljs
window.Clipboard = new ClipboardJS('.code-block-copy-btn')