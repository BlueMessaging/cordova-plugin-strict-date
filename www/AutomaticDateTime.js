var exec = require('cordova/exec');

function StrictDateTask() {
	var self = this;
}

StrictDateTask.prototype.isEnabled = function(callback) {
	exec(function(result) {
        callback(result);        
    }, 
    function(error) {
        console.log(error);
    }, 'AutomaticDateTime', 'isEnabled', []);
};

StrictDateTask.prototype.toString = function() {
	return "AutomaticDateTime ready for action";
};

module.exports = new StrictDateTask();