angular.module('app',[]).controller('indexController', function ($scope, $rootScope, $http) {
    const contextPath = 'http://localhost:8189/';

    $scope.loadStudents = function () {

        $http.get(contextPath + 'api/v1/students')
            .then(function (response) {
                console.log(response.data)
                $scope.students = response.data;
                $scope.getStudent = null;

            });
    };

    $scope.deleteStudent = function (id) {
        $http.delete(contextPath + 'api/v1/students/' + id)
            .then(function (response) {
                $scope.loadStudents();
            });
    }

    $scope.loadStudent = function (id) {
        $http.get(contextPath + 'api/v1/students/' + id)
            .then(function (response) {
                console.log(response.data)
                $scope.getStudent = response.data;

            });
    }

    $scope.saveStudent = function () {
        $http.post('api/v1/students/', $scope.getStudent)
            .then(function successCallback(response) {
                $scope.loadStudents();

            }, function errorCallback(response) {
                console.log(response)
            });
    };

    $scope.newStudent = function () {
        $scope.getStudent = {};
    };

    $scope.loadStudents();

});
