function loadHtml(url, divholder, additionalCallback) {
	divholder.html("");
	$.get(url, function(data) {
		divholder.html(data);
		if (typeof (additionalCallback) != 'undefined') {
			additionalCallback();
		}
	});
}

function refreshPage() {
	location.reload();
}

function drag(ev) {
	ev.dataTransfer.setData("Text", ev.target.id);
}

function drop(ev) {
	ev.preventDefault();
	var data = ev.dataTransfer.getData("Text");
	ev.target.appendChild(document.getElementById(data));

	var droppedColId = $(ev.target).attr('id');
	changeTaskStatus(droppedColId, data);
}
function allowDrop(ev) {
	ev.preventDefault();
}

function showError(msg) {
	var to_show = "Unexpected problem has occured. Please contact with administrator.";
	if (typeof (msg) != 'undefined') {
		to_show += " \n" + msg + ".";
	}
	alert(eh(to_show));
	refreshPage();
}

function showWarnAndReload(msg) {
	alert(eh(msg));
	refreshPage();
}

function putErrors($div_el, msg) {
	$div_el.addClass("bg-danger");
	$div_el.html(eh(msg).replace('\n', '<br/>'));
}
function clearErrors($div_el) {
	$div_el.removeClass("bg-danger");
	$div_el.html("");
}

/**
 * ESCAPE HTML
 * 
 * @param str
 * @returns
 */
function eh(str) {
	return _.str.escapeHTML(str);
}


function clone(obj) {
    if(obj === null || typeof(obj) !== 'object')
        return obj;

    var temp = obj.constructor(); // changed

    for(var key in obj) {
        if(Object.prototype.hasOwnProperty.call(obj, key)) {
            temp[key] = clone(obj[key]);
        }
    }
    return temp;
}