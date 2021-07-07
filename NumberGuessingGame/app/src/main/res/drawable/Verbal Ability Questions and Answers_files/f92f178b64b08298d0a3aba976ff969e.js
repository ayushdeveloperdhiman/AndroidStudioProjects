(function(){/*

 Copyright The Closure Library Authors.
 SPDX-License-Identifier: Apache-2.0
*/
'use strict';var n=this||self;var r=class{constructor(a,b){this.g=b===p?a:""}};r.prototype.i=!0;r.prototype.h=function(){return this.g.toString()};r.prototype.toString=function(){return this.g.toString()};function aa(a){return a instanceof r&&a.constructor===r?a.g:"type_error:SafeUrl"}var ba=/^(?:(?:https?|mailto|ftp):|[^:/?#]*(?:[/?#]|$))/i,p={};function u(a,b){b instanceof r||b instanceof r||(b="object"==typeof b&&b.i?b.h():String(b),ba.test(b)||(b="about:invalid#zClosurez"),b=new r(b,p));a.href=aa(b)};function v(a){v[" "](a);return a}v[" "]=function(){};var ca={},w=null;var da="function"===typeof Uint8Array;const ea=Symbol("IS_REPEATED_FIELD");function z(a){Array.isArray(a)&&!Object.isFrozen(a)&&(a[ea]=!0);return a};function A(){}let B;function C(a,b,c){a.g=null;B&&(b||(b=B),B=null);var d=a.constructor.C;b||(b=d?[d]:[]);a.j=d?0:-1;a.h=b;a:{if(b=a.h.length)if(--b,d=a.h[b],!(null===d||"object"!=typeof d||Array.isArray(d)||da&&d instanceof Uint8Array)){a.l=b-a.j;a.i=d;break a}a.l=Number.MAX_VALUE}a.m={};if(c)for(b=0;b<c.length;b++)if(d=c[b],d<a.l){d+=a.j;var f=a.h[d];f?z(f):a.h[d]=D}else E(a),(f=a.i[d])?z(f):a.i[d]=D}const D=Object.freeze(z([]));function E(a){let b=a.l+a.j;a.h[b]||(a.i=a.h[b]={})}
function F(a,b){if(b<a.l){b+=a.j;var c=a.h[b];return c!==D?c:a.h[b]=z([])}if(a.i)return c=a.i[b],c!==D?c:a.i[b]=z([])}function G(a,b,c){a=F(a,b);return null==a?c:a}function H(a,b){a=F(a,b);a=null==a?a:!!a;return null==a?!1:a}function fa(a,b){""!==b?2<a.l?a.h[2+a.j]=b:(E(a),a.i[2]=b):2<a.l?a.h[2+a.j]=null:(E(a),delete a.i[2])}function ha(a,b,c){a.g||(a.g={});if(!a.g[c]){let d=F(a,c);d&&(a.g[c]=new b(d))}return a.g[c]}
function I(a,b,c){a.g||(a.g={});if(!a.g[c]){var d=F(a,c);let f=[];for(let g=0;g<d.length;g++)f[g]=new b(d[g]);a.g[c]=f}b=a.g[c];b==D&&(b=a.g[c]=[]);return b}function J(a){if(a.g)for(var b in a.g){var c=a.g[b];if(Array.isArray(c))for(var d=0;d<c.length;d++)c[d]&&J(c[d]);else c&&J(c)}return a.h}
function ia(a,b){switch(typeof b){case "number":return isNaN(b)||Infinity===b||-Infinity===b?String(b):b;case "object":if(da&&null!=b&&b instanceof Uint8Array){var c;void 0===c&&(c=0);if(!w){w={};a="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".split("");for(var d=["+/=","+/","-_=","-_.","-_"],f=0;5>f;f++){var g=a.concat(d[f].split(""));ca[f]=g;for(var e=0;e<g.length;e++){var h=g[e];void 0===w[h]&&(w[h]=e)}}}c=ca[c];a=Array(Math.floor(b.length/3));d=c[64]||"";for(f=g=0;g<b.length-
2;g+=3){var k=b[g],l=b[g+1];h=b[g+2];e=c[k>>2];k=c[(k&3)<<4|l>>4];l=c[(l&15)<<2|h>>6];h=c[h&63];a[f++]=e+k+l+h}e=0;h=d;switch(b.length-g){case 2:e=b[g+1],h=c[(e&15)<<2]||d;case 1:b=b[g],a[f]=c[b>>2]+c[(b&3)<<4|e>>4]+h+d}return a.join("")}}return b}A.prototype.toString=function(){return J(this).toString()};var ma=class extends A{constructor(a){super();C(this,a,null)}};function na(a,b){if(!a||/[?&]dsh=1(&|$)/.test(a))return null;if(/[?&]ae=1(&|$)/.test(a)){var c=/[?&]adurl=([^&]+)/.exec(a);if(!c)return null;b=b?c.index:a.length;try{return{u:a.slice(0,b)+"&act=1"+a.slice(b),v:decodeURIComponent(c[1])}}catch(d){return null}}if(/[?&]ae=2(&|$)/.test(a)){c=a;let d="";b&&(b=a.indexOf("&adurl="),0<b&&(c=a.slice(0,b),d=a.slice(b)));return{u:`${c}&act=1${d}`,v:`${c}&dct=1${d}`}}return null};var oa={};function pa(){if(oa!==oa)throw Error("Bad secret");};var qa=class{};class ra extends qa{constructor(a){super();pa();this.g=a}toString(){return this.g}};var sa=class{};class K extends sa{constructor(a){super();pa();this.g=a}toString(){return this.g}}var ta=new K("about:invalid#zTSz");function ua(a){if(a instanceof sa)if(a instanceof K)a=a.g;else throw Error("wrong type");else a=aa(a);return a};class va{constructor(a,b){this.error=a;this.context=b.context;this.msg=b.message||"";this.id=b.id||"jserror";this.meta={}}};var wa=/^(?:([^:/?#.]+):)?(?:\/\/(?:([^\\/?#]*)@)?([^\\/?#]*?)(?::([0-9]+))?(?=[\\/?#]|$))?([^?#]+)?(?:\?([^#]*))?(?:#([\s\S]*))?$/;function xa(a,b,c){if(Array.isArray(b))for(var d=0;d<b.length;d++)xa(a,String(b[d]),c);else null!=b&&c.push(a+(""===b?"":"="+encodeURIComponent(String(b))))}
function ya(a,b){var c=[];for(d in b)xa(d,b[d],c);b=c.join("&");if(b){c=a.indexOf("#");0>c&&(c=a.length);var d=a.indexOf("?");if(0>d||d>c){d=c;var f=""}else f=a.substring(d+1,c);a=[a.substr(0,d),f,a.substr(c)];c=a[1];a[1]=b?c?c+"&"+b:b:c;a=a[0]+(a[1]?"?"+a[1]:"")+a[2]}return a};function N(a){try{var b;if(b=!!a&&null!=a.location.href)a:{try{v(a.foo);b=!0;break a}catch(c){}b=!1}return b}catch(c){return!1}}function za(a,b){if(a)for(const c in a)Object.prototype.hasOwnProperty.call(a,c)&&b.call(void 0,a[c],c,a)};function Aa(a,b){a.google_image_requests||(a.google_image_requests=[]);const c=a.document.createElement("img");c.src=b;a.google_image_requests.push(c)}var Ba=a=>{var b;if(b=n.navigator)b=n.navigator.userAgent,b=/Chrome/.test(b)&&!/Edge/.test(b)?!0:!1;b&&n.navigator.sendBeacon?n.navigator.sendBeacon(a):Aa(n,a)};var Ca=document,Da=window;class Ea{constructor(a){this.B=a}}function O(a){return new Ea(b=>b.substr(0,a.length+1).toLowerCase()===a+":")}const Fa=new Ea(a=>/^[^:]*([/?#]|$)/.test(a));var Ga=O("http"),Ha=O("https"),Ia=O("ftp"),Ja=O("mailto"),Ka=O("intent"),La=O("market"),Ma=O("itms"),Na=O("itms-appss");const Oa=[O("data"),Ga,Ha,Ja,Ia,Fa];function Pa(a,b=Oa){for(let c=0;c<b.length;++c){const d=b[c];if(d instanceof Ea&&d.B(a))return new K(a)}}function Qa(a,b=Oa){return Pa(a,b)||ta};const Ra=[Ga,Ha,Ja,Ia,Fa,La,Ma,Ka,Na];function Sa(a,b){if(a instanceof r)return a;const c=Qa(a,Ra);c===ta&&b(a);return new r(ua(c),p)}var Ta=()=>{var a=`${"http:"===Da.location.protocol?"http:":"https:"}//${"pagead2.googlesyndication.com"}/pagead/gen_204`;return b=>{b=ya(a,{id:"unsafeurl",ctx:599,url:b});navigator.sendBeacon&&navigator.sendBeacon(b,"")}};var Ua=!!window.google_async_iframe_id;let P=Ua&&window.parent||window;const Va=/^https?:\/\/(\w|-)+\.cdn\.ampproject\.(net|org)(\?|\/|$)/;var Wa=class{constructor(a,b){this.g=a;this.h=b}},Xa=class{constructor(a,b){this.url=a;this.A=!!b;this.depth=null}};function Q(a,b){const c={};c[a]=b;return[c]}function Ya(a,b,c,d,f){const g=[];za(a,function(e,h){(e=Za(e,b,c,d,f))&&g.push(h+"="+e)});return g.join(b)}
function Za(a,b,c,d,f){if(null==a)return"";b=b||"&";c=c||",$";"string"==typeof c&&(c=c.split(""));if(a instanceof Array){if(d=d||0,d<c.length){const g=[];for(let e=0;e<a.length;e++)g.push(Za(a[e],b,c,d+1,f));return g.join(c[d])}}else if("object"==typeof a)return f=f||0,2>f?encodeURIComponent(Ya(a,b,c,d,f+1)):"...";return encodeURIComponent(String(a))}function $a(a){let b=1;for(const c in a.h)b=c.length>b?c.length:b;return 3997-b-a.i.length-1}
function eb(a){let b="https://pagead2.googlesyndication.com/pagead/gen_204unsafeurl&",c=$a(a)-25;if(0>c)return"";a.g.sort(function(g,e){return g-e});let d=null,f="";for(let g=0;g<a.g.length;g++){const e=a.g[g],h=a.h[e];for(let k=0;k<h.length;k++){if(!c){d=null==d?e:d;break}let l=Ya(h[k],a.i,",$");if(l){l=f+l;if(c>=l.length){c-=l.length;b+=l;f=a.i;break}d=null==d?e:d}}}a="";null!=d&&(a=f+"trn="+d);return b+a}class fb{constructor(){this.i="&";this.h={};this.j=0;this.g=[]}};function gb(a){if(1>Math.random())try{let b;a instanceof fb?b=a:(b=new fb,za(a,(d,f)=>{var g=b,e=g.j++;d=Q(f,d);g.g.push(e);g.h[e]=d}));const c=eb(b);c&&Ba(c)}catch(b){}};let R=null;var ib=()=>{const a=n.performance;return a&&a.now&&a.timing?Math.floor(a.now()+a.timing.navigationStart):Date.now()},jb=()=>{const a=n.performance;return a&&a.now?a.now():null};class kb{constructor(a,b){var c=jb()||ib();this.label=a;this.type=b;this.value=c;this.duration=0;this.uniqueId=Math.random();this.slotId=void 0}};const S=n.performance,lb=!!(S&&S.mark&&S.measure&&S.clearMarks),U=function(a){let b=!1,c;return function(){b||(c=a(),b=!0);return c}}(()=>{var a;if(a=lb){var b;if(null===R){R="";try{a="";try{a=n.top.location.hash}catch(c){a=n.location.hash}a&&(R=(b=a.match(/\bdeid=([\d,]+)/))?b[1]:"")}catch(c){}}b=R;a=!!b.indexOf&&0<=b.indexOf("1337")}return a});function nb(a){a&&S&&U()&&(S.clearMarks(`goog_${a.label}_${a.uniqueId}_start`),S.clearMarks(`goog_${a.label}_${a.uniqueId}_end`))}
class ob{constructor(){var a=V;this.events=[];this.h=a||n;let b=null;a&&(a.google_js_reporting_queue=a.google_js_reporting_queue||[],this.events=a.google_js_reporting_queue,b=a.google_measure_js_timing);this.g=U()||(null!=b?b:1>Math.random())}start(a,b){if(!this.g)return null;a=new kb(a,b);b=`goog_${a.label}_${a.uniqueId}_start`;S&&U()&&S.mark(b);return a}end(a){if(this.g&&"number"===typeof a.value){a.duration=(jb()||ib())-a.value;var b=`goog_${a.label}_${a.uniqueId}_end`;S&&U()&&S.mark(b);!this.g||
2048<this.events.length||this.events.push(a)}}};function pb(a){let b=a.toString();a.name&&-1==b.indexOf(a.name)&&(b+=": "+a.name);a.message&&-1==b.indexOf(a.message)&&(b+=": "+a.message);if(a.stack){a=a.stack;try{-1==a.indexOf(b)&&(a=b+"\n"+a);let c;for(;a!=c;)c=a,a=a.replace(/((https?:\/..*\/)[^\/:]*:\d+(?:.|\n)*)\2/,"$1");b=a.replace(/\n */g,"\n")}catch(c){}}return b};if(Ua&&!N(P)){let a="."+Ca.domain;try{for(;2<a.split(".").length&&!N(P);)Ca.domain=a=a.substr(a.indexOf(".")+1),P=window.parent}catch(b){}N(P)||(P=window)}const V=P,W=new ob;var qb=()=>{V.google_measure_js_timing||(W.g=!1,W.events!=W.h.google_js_reporting_queue&&(U()&&Array.prototype.forEach.call(W.events,nb,void 0),W.events.length=0))};"number"!==typeof V.google_srt&&(V.google_srt=Math.random());
if("complete"==V.document.readyState)qb();else if(W.g){var rb=()=>{qb()},sb=V;sb.addEventListener&&sb.addEventListener("load",rb,!1)};function tb(a){const {s:b,o:c}=ub(a.href);u(a,Sa(b,Ta()));return c}function vb(a,b,c=-1){if(b)if(300>Date.now()-c)a=!1;else if(b=a.getAttribute("data-orig-async-clicktrack-url")){const {s:d,o:f}=ub(b);u(a,Sa(d,Ta()));a=f}else a.setAttribute("data-orig-async-clicktrack-url",a.href),a=tb(a);else a=tb(a);return a}function ub(a){const b=na(a,!0);return b?navigator.sendBeacon?navigator.sendBeacon(wb(b.u,"&ri=1"),"")?{s:b.v,o:!0}:{s:wb(a,"&ri=2"),o:!1}:{s:wb(a,"&ri=16"),o:!1}:{s:a,o:!1}}
function wb(a,b){const c=a.search(/&adurl=/);return 0>c?a+b:a.slice(0,c)+b+a.slice(c)}function xb(a){return null!=a&&-1===a.indexOf("dbm/clk")&&null!==na(a)};function yb(a,b,c=!1){if(!isNaN(b)&&0<b){var d=a.dataset.onReadyTs;d=d?parseInt(d,10):NaN;!c&&!isNaN(d)&&0<d||(a.dataset.onReadyTs=String(b))}};var zb=class{j(){}};var Ab=class extends A{constructor(a){super();C(this,a,null)}};var Cb=class extends A{constructor(a){super();C(this,a,Bb)}},Bb=[1];var Eb=class extends A{constructor(a){super();C(this,a,Db)}},Db=[1,2];var Fb=class extends A{constructor(a){super();C(this,a,null)}};function Gb(a,b){(a=G(a,5,""))&&Aa(Da,a+"&label="+b)}function Hb(a,b){!isNaN(b)&&0<b&&(isNaN(a.g)||a.g<b)&&(a.g=b)}
function Ib(a,b,c){const d=ha(b,Eb,4);if(!d)return!0;for(var f of I(d,Cb,1)){a:{var g=f;var e=c,h=G(g,2,"");h=h?document.querySelectorAll(h):[e.currentTarget];for(let q=0;q<h.length;++q){const t=h[q].getBoundingClientRect();var k=g,l=F(k,1);k.m||(k.m={});if(!k.m[1]){for(var m=0;m<l.length;m++)l[m]=+l[m];k.m[1]=!0}k=l;l=e.clientX;m=e.clientY;if(l>=t.left&&l<=t.right&&m>=t.top&&m<=t.bottom&&(m-k[0]<t.top||l+k[1]>t.right||m+k[2]>t.bottom||l-k[3]<t.left)){g=!1;break a}}g=!0}if(!g)return Gb(b,"blocked_border_click"),
!1}for(const q of I(d,Ab,2))if(f=a,g=q,e=c.currentTarget,h=e.dataset.onReadyTs,Hb(f,h?parseInt(h,10):NaN),e=e.dataset.onShowTs,Hb(f,e?parseInt(e,10):NaN),e=f.g,isNaN(e)||!(0<e)||Date.now()<f.g+G(g,1,0))return Gb(b,"blocked_fast_click"),!1;return H(d,3)&&"function"==typeof n.copfcChm?(n.copfcChm(c),Gb(b,"onepointfiveclick_first_click"),!1):!0}class Jb{constructor(){this.g=NaN}};function Kb(){return a=>{a=ya("https://pagead2.googlesyndication.com/pagead/gen_204",{id:"unsafeurl",ctx:620,url:a});navigator.sendBeacon&&navigator.sendBeacon(a,"")}};function Lb(a,b){const c=Qa(a,Mb);if(c===ta){a=Error("URL not recognized as safe: "+a);let x;try{const y=new fb;var d=y;d.g.push(1);d.h[1]=Q("context",b);a.error&&a.meta&&a.id||(a=new va(a,{message:pb(a)}));if(a.msg){d=y;var f=a.msg.substring(0,512);d.g.push(2);d.h[2]=Q("msg",f)}f=y;var g=[a.meta||{}];f.g.push(3);f.h[3]=g;a=n;g=[];f=null;do{var e=a;if(N(e)){var h=e.location.href;f=e.document&&e.document.referrer||null}else h=f,f=null;g.push(new Xa(h||""));try{a=e.parent}catch(L){a=null}}while(a&&
e!=a);for(let L=0,ab=g.length-1;L<=ab;++L)g[L].depth=ab-L;e=n;if(e.location&&e.location.ancestorOrigins&&e.location.ancestorOrigins.length==g.length-1)for(h=1;h<g.length;++h){var k=g[h];k.url||(k.url=e.location.ancestorOrigins[h-1]||"",k.A=!0)}var l=g;let T=new Xa(n.location.href,!1);e=null;const ka=l.length-1;for(k=ka;0<=k;--k){var m=l[k];!e&&Va.test(m.url)&&(e=m);if(m.url&&!m.A){T=m;break}}m=null;const Ob=l.length&&l[ka].url;0!=T.depth&&Ob&&(m=l[ka]);x=new Wa(T,m);if(x.h){l=y;var q=x.h.url||"";
l.g.push(4);l.h[4]=Q("top",q)}var t={url:x.g.url||""};if(x.g.url){var la=x.g.url.match(wa),M=la[1],bb=la[3],cb=la[4];q="";M&&(q+=M+":");bb&&(q+="//",q+=bb,cb&&(q+=":"+cb));var db=q}else db="";M=y;t=[t,{url:db}];M.g.push(5);M.h[5]=t;gb(y)}catch(y){try{gb({context:"ecmserr",rctx:b,msg:pb(y),url:x&&x.g.url})}catch(T){}}}return c}var Mb=[Ha,Ka,La,Ma,Na];var Nb="href rel src srcdoc action formaction sandbox cite srccite poster icon style".split(" ");(function(a){if(!Array.isArray(a)||!Array.isArray(a.raw))throw new TypeError("safeAttr is a template literal tag function and should be called using the tagged template syntax. For example, safeAttr`foo`;");const b=a[0].toLowerCase();Nb.forEach(c=>{if(0===c.indexOf(b))throw Error(`Prefix '${a[0]}' does not guarantee the attribute `+"to be safe as it is also a prefix for "+`the security sensitive attribute '${c}'. `+"Please use native or safe DOM APIs to set the attribute.");});return new ra(b)})`x-`;function X(a,b){a.dispatchEvent(new CustomEvent("customError",{detail:{message:b}}))}
function Y(a){const b=a.currentTarget;let c=a.type;null!=a.clientX&&null!=a.clientY&&(c+=` [${a.clientX},${a.clientY}]`);a=a.target;let d=!1,f=!1,g=!1;for(;a!==b;){var e=a.attributes;for(var h=0;h<e.length;++h){var k=e[h];!d&&k.name.match(/^x-.+-l$/)?(c="[l="+k.value+"]"+c,d=!0):!f&&k.name.match(/^x-.+-v$/)?(c="[v="+k.value+"]"+c,f=!0):!g&&k.name.match(/^x-.+-e$/)&&(c="[e="+k.value+"]"+c,g=!0)}e=a.parentElement||b;if(!g)for(h=e.children,k=0;k<h.length;k++)if(h[k]===a){c=`>${k}`+c;break}a=e}return c}
;function Pb(a,b){a.g=b}function Qb(a){for(;!a.id;){const b="goog-js-util-"+Math.random().toString(36).substr(2,5);if(!document.getElementById(b)){a.id=b;break}}return a.id}var Rb=class{constructor(){this.g=!1}};var Tb=class extends A{constructor(a){super();C(this,a,Sb)}},Sb=[1];function Ub(a,b,c){Pb(a.l,H(b,2));H(b,4)&&(c.dataset.useCustomTabsInSdk="true");if(G(b,5,""))for(a=c.querySelectorAll(G(b,5,"")),b=0;b<a.length;++b)a[b].addEventListener("click",()=>{})}
function Vb(a,b){let c=null,d=null;b.addEventListener("mousedown",f=>{for(var g=f.currentTarget,e=f.target;null!==e&&e!==g.parentElement&&"A"!==e.tagName;)e=e.parentElement;c=e===g.parentElement?null:e;a:{if(null!=a.g){g=f.currentTarget;e=f.target;if(H(a.g,2)&&1==e.children.length&&"SPAN"==e.children[0].tagName){var h=e.children[0],k=h.getBoundingClientRect();k.left<=f.clientX&&f.clientX<=k.right&&k.top<=f.clientY&&f.clientY<=k.bottom&&(e=h)}for(h=I(a.g,Fb,1);e!=g.parentElement;){e.matches=e.matches||
e.webkitMatchesSelector||e.mozMatchesSelector||e.msMatchesSelector||e.oMatchesSelector;for(k=0;k<h.length;++k){const l=h[k];if(e.matches(G(l,1,""))){d=l;break a}}e=e.parentElement}}d=null}if(c&&d&&G(d,2,"")){e=d;g=c;if(h=G(e,2,""))u(g,new r(ua(Lb(h,618)),p)),g.target=G(e,3,"")||"_top";delete g.dataset.u2FinalUrl;delete g.dataset.u2TrackingUrl;(h=G(e,6,""))&&(g.dataset.u2FinalUrl=h);(h=G(e,7,""))&&(g.dataset.u2TrackingUrl=h);delete g.dataset.appClickInfo;(e=ha(e,ma,9))&&(g.dataset.appClickInfo=JSON.stringify(e.h&&
J(e),ia));g=f.currentTarget;"function"===typeof window.st?window.st(Qb(c)):X(g,`js-util: st() missing: ${Y(f)}`);H(a.g,6)&&c.dispatchEvent(new CustomEvent("CUSTOM_MOUSE_DOWN",{bubbles:!0}))}});b.addEventListener("click",f=>{if(c&&d&&G(d,2,"")&&Ib(a.m,d,f)&&!f.defaultPrevented){var g=c,e=f.currentTarget;a:{var h=f.currentTarget;var k=f.target;if(a.l.g&&1==k.children.length&&"SPAN"==k.children[0].tagName){var l=k.children[0];const m=l.getBoundingClientRect();m.left<=f.clientX&&f.clientX<=m.right&&m.top<=
f.clientY&&f.clientY<=m.bottom&&(k=l)}for(;k!=h;){l=k.getAttribute("x-code");if(null!=l){h=parseInt(l,10);break a}k=k.parentElement}h=17}k=h;"function"===typeof window.ja?window.ja(Qb(g),k):X(e,`js-util: ja() missing: ${Y(f)}`);e=f.currentTarget;(h=g.href)?(l=[],0==/&nb=[^&]+/i.test(h)&&l.push("&nb="+k),0==/&nx=[^&]+/i.test(h)&&l.push("&nx="+Math.round(f.clientX-e.offsetLeft)),0==/&ny=[^&]+/i.test(h)&&l.push("&ny="+Math.round(f.clientY-e.offsetTop)),0<l.length&&(k=l.join(""),l=h.indexOf("&adurl="),
h=0>l?h+k:h.substring(0,l)+k+h.substring(l),u(g,Sa(h,Kb())),X(e,`js-util: ja() filling: ${k} ${Y(f)}`))):X(e,`js-util: href is empty: ${Y(f)}`);g=c;e=G(d,2,"");h=e.indexOf("&adurl=");0>h||(e=e.slice(h),h=g.href||"",k=h.indexOf(e),0>k||(l=h.slice(k+e.length))&&u(g,new r(ua(Lb(h.slice(0,k)+l+e,619)),p)));H(a.g,6)?(c.dispatchEvent(new CustomEvent("CUSTOM_CLICK",{bubbles:!0})),f.stopImmediatePropagation(),f.preventDefault()):(f=c,(xb(f.href)||f.getAttribute("data-orig-async-clicktrack-url")&&xb(f.getAttribute("data-orig-async-clicktrack-url")))&&
H(d,8)&&vb(c,H(d,10),a.i)&&(a.i=Date.now()))}else f.stopImmediatePropagation(),f.preventDefault()})}function Wb(a,b){if(b instanceof CustomEvent)for(const c of b.detail.changeConfigs)b=I(a.g,Fb,1).find(d=>G(d,1,"")===c.selector),void 0!==b&&fa(b,c.href)}
var Xb=class extends zb{constructor(){super();this.g=null;this.m=new Jb;this.l=new Rb;this.h=!1;this.i=-1}j(a){a:{var b=a.getElementsByTagName("META");for(let c=0;c<b.length;++c)if("exit"===b[c].getAttribute("name")){b=b[c].getAttribute("content")||"";break a}b=""}b?(B=b=b?JSON.parse(b):null,b=new Tb(b),B=null):b=null;if(this.g=b)yb(a,Date.now(),H(this.g,7)),Ub(this,this.g,a),this.h||(this.h=!0,Vb(this,a))}};const Z=document.getElementById("mys-content");if(Z){const a=new Xb;Z.addEventListener("browserReady",()=>{a.j(Z)});Z.addEventListener("changeExitConfig",b=>void Wb(a,b))};}).call(this);
