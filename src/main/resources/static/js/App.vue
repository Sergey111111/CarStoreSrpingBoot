<template>
  <div id="app">
    <div class="container">
      <div class="row">
        <div class="col-xs-5 col-md-3 col-lg-2 vcenter">
          <div>
            <user-info
              v-if="profile != null"
              :profile="profile"
              @logOut="logOut"
              @add="add"
              @showAll="showAll"
            ></user-info>
            <unlogged v-else>Google authorization required
              <a href="/login">Log-in</a>
            </unlogged>
            <!--<unlogged v-else-->
            <!--@authorize="authorize"-->
            <!--&gt;</unlogged>-->
          </div>
        </div>

        <div class="col-xs-5 col-md-7 col-lg-8 vcenter">
          <div>

            <car-table v-if="state == 'loadedTable'"
                       :cars="this.cars"
                       @showCar="showCar"
            ></car-table>
            <car-info
              v-else-if="state == 'showCar'"
              :car="this.car"
              :carCreator="this.carCreator"
            ></car-info>
            <add-car
              v-else-if="state =='addCar'"
              :user="this.profile"
            ></add-car>
            <div v-else-if="state =='void'"></div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

  import axios from 'axios';

  export default {
    name: 'app',
    data() {
      return {
        user: '',
        login: '',
        state: 'loadedTable',
        carId: '-1',
        profile: frontendData.profile,
        cars: frontendData.cars,
        car: {
        },
        carCreator:{}

      }
    },

    methods: {
      authorize() {
        // axios.get('http://localhost:9000/login').then(result => {
        //   this.registrationForm = result.data
        // });
        if (this.user == '') {
          this.login = 'loggedin';
          this.state = 'loadedTable';
          console.log('logged in');
        } else {
          this.state = 'result';
        }
      },
      logOut() {
        this.profile = '';
        this.state = 'void';
        console.log('logged out');
      },
      showAll() {
        axios.get('http://localhost:9000/car').then(result => {
          ;
        });
        this.state = 'loadedTable';
        console.log('showing cars...');
      },

      showCar(id) {
        axios.get('http://localhost:9000/car/'+ id).then(result => {
          console.log(result.data)
          this.car = result.data;
          this.carCreator = this.car.user;
        });
        this.carId = id;
        this.state = 'showCar';
        console.log('showing car...');
      },
      add() {
        this.state = 'addCar';
        console.log('add an car...');
      },

    }
  }
</script>

<style scoped>
  .container {
    background: aliceblue;
    padding: 40px;
  }
</style>
