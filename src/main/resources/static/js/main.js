import Vue from 'vue'
import App from 'App.vue'
import VueCarousel from 'vue-carousel';

import CarTable from './components/CarTable.vue';
import UserInfo from './components/UserInfo.vue';
import AddCar from './components/AddCar.vue';
import Unlogged from './components/Unlogged.vue';
import CarInfo from './components/CarInfo.vue';
import PictureLoader from './components/PictureLoader.vue';

Vue.use(VueCarousel);
Vue.component('CarTable',CarTable);
Vue.component('UserInfo',UserInfo);
Vue.component('AddCar',AddCar);
Vue.component('Unlogged',Unlogged);
Vue.component('CarInfo',CarInfo);
Vue.component('PictureLoader', PictureLoader);

new Vue({
  el: '#app',
  render: h => h(App)
})
