var app = new Vue({
    el: '#app',
    template:
    '<div>' +
    '<div v-if="!profile">Google authorization required <a href="/login">Sign in</a></div>' +
    '<div v-else>' +
    '<div>{{profile.name}}&nbsp;<a href="/logout">Logout</a></div>' +
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
    '        <td>Created</td>' +
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

Vue.component('message-row', {
    props: ['message'],
    template: '<tr>' +
    '<td>{{message.id}}</td>' +
    '<td>{{message.user}}</td>' +
    '<td>{{message.text}}</td>' +
    '<td>{{message.created}}</td>' +
    '</tr>'
});

Vue.component('messages-list', {
    props: ['messages'],
    template: '<table  class="table table-bordred table-striped">' +
    '<table-head/>' +
    '<tbody>' +
    '<message-row v-for="message in messages" :message="message" :key="message.id"></message-row>' +
    '</tbody> ' +
    '</table>',
    created: function () {
        advsApi.get().then(result =>
        console.log(result)
    )
    }
});

var table = new Vue({
    el: '#cars-table',
    template: '<messages-list :messages="messages"/></table>',
    data: {
        messages: [
            {id: "1", user: "Vasya", text: "Sell the car", created: "2018-01-12 12:22:00"},
            {id: "2", user: "Vasya1", text: "Sell the car", created: "2018-01-12 12:22:00"},
            {id: "31", user: "Vasya2", text: "Sell the car", created: "2018-01-12 12:22:00"},
            {id: "121", user: "Vasya3", text: "Sell the car", created: "2018-01-12 12:22:00"}]
    }
});

