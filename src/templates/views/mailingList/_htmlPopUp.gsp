
[ <a href="javascript:void(0)" onClick=\"javascript:${scriptCall}${t}('${t}');\">${t}</a> :${mcat?.name} ] -
<g:javascript>
function ${scriptCall}${t}(t) {\n"
var link = \"${g.createLink(controller: '+ccontrol+', action: '+cact+')}?id=\" + t;
window.open(link, '', 'width=600,height=400');
}
</g:javascript>