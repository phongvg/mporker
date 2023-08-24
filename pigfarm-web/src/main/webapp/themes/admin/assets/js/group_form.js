'use strict';

const rolesSelected = [];
var GroupComponent = function() {
	var _setOptionsSelected = function() {
		var optionsSelected = $("#bootstrap-duallistbox-selected-list_roleNames").children('option');
		for (let i = 0; i < optionsSelected.length; i++) {
			rolesSelected.push(optionsSelected[i].value);
		}
		console.log('count selected', rolesSelected.length);
	}

	var _onSubmit = function() {
		$('#groupSubmit').on('click', function(e) {
			e.preventDefault();
			_setOptionsSelected();
			console.log('roles selected', rolesSelected);
			$('#roleNames').val(rolesSelected);
			$('#formSubmit').submit();
		})
	}

	return {
		init: function() {
			_onSubmit();
		}
	}
}();

document.addEventListener('DOMContentLoaded', function() {
	GroupComponent.init();
});