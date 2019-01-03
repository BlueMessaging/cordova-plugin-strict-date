var exec = require('cordova/exec');

function StrictDateTask() {
	var self = this;
}

StrictDateTask.prototype.isAutomaticDateTimeEnabled = function(callback) {
	exec(function(result) {
        callback(result);        
    }, 
    function(error) {
        console.log(error);
    }, 'StrictDate', 'isAutomaticDateTimeEnabled', []);
};

StrictDateTask.prototype.toString = function() {
	return "StrictDate ready for action";
};

module.exports = new StrictDateTask();