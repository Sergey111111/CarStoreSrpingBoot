var app = new Vue({
    el: '#app',
    template:
    '<div>' +
    '<div v-if="!profile">Необходимо авторизоваться через <a href="/login">Google</a></div>' +
    '<div v-else>' +
    '<div>{{profile.name}}&nbsp;<a href="/logout">Выйти</a></div>' +
    // '<messages-list :messages="messages" />' +
    '</div>' +
    '</div>',
    data: {
        // messages: frontendData.messages,
        profile: frontendData.profile
    }
});

var userpic = new Vue({
    el:'#userpic',
    template:
'<div><img :src="profile.userpic"/>  </div>',
    data: {

        profile: frontendData.profile
    }
});