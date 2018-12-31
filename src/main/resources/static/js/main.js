Vue.component('view-state',{

});

var state = 'board';



var app = new Vue({
    el: '#app',
    template:
    '<div>' +
    '<div v-if="!profile">Google authorization required <a href="/login">Sign in</a></div>' +
    '<div v-else>' +
    '<div>You have logged in as {{profile.name}}&nbsp;<a href="/logout">Logout</a></div>' +
    '</div>' +
    '</div>',
    data: {
        profile: frontendData.profile
    }
});

Vue.component('table-head', {
    template: ' <thead>' +
    '    <tr>' +
    '        <td>Id</td>' +
    '        <td>User</td>' +
    '        <td>Text</td>' +
    '        <td>Car</td>' +
    '    </tr>' +
    '    </thead>'
});

var userpic = new Vue({
    el: '#userpic',
    template:
        '<div><img :src="profile.userpic"/>  </div>',
    data: {
        profile: frontendData.profile
    }
});

var advsApi = Vue.resource('/adv');

Vue.component('adv-row', {
    props: ['adv'],
    template: '<tr>' +
    '<td>{{adv.id}}</td>' +
    '<td>{{adv.user.name}}</td>' +
    '<td>{{adv.text}}</td>' +
    '<td>{{adv.car.name}}</td>' +
    '</tr>'
});

Vue.component('messages-list', {
    props: ['advs'],
    template: '<table class="table table-bordred table-striped">' +
    '<table-head/>' +
    '<tbody>' +
    '<adv-row v-for="adv in advs" :adv="adv" :key="adv.id"></adv-row>' +
    '</tbody> ' +
    '</table>',
    created: function () {
        advsApi.get().then(result =>
        result.json().then(data =>
            data.forEach(adv => this.advs.push(adv))
        )
    )
    }
});

var table = new Vue({
    el: '#cars-table',
    template: '<messages-list :advs="advs"/></table>',
    data: {
        advs: []
    }
});

