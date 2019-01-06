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
                       :advs="this.advs"
                       @showCar="showCar"
            ></car-table>
            <car-info
              v-else-if="state == 'showCar'"
              :car="this.car"
              :adv="this.advs[1]"
            ></car-info>
            <add-car
              v-else-if="state =='addCar'"

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
        advs: frontendData.advs,
        // advs: [
        //   {
        //     id: '1',
        //     user: 'Vasya Ivanov',
        //     text: "Sell a car",
        //     car: 'BMW',
        //     created: 'yyyy-mm-dd hh:mm:ss'
        //   },
        //   {
        //     id: '2',
        //     user: 'Vasya Ivanov',
        //     text: "Sell a car",
        //     car: 'BMW',
        //     created: 'yyyy-mm-dd hh:mm:ss'
        //   },
        //   {
        //     id: '3',
        //     user: 'Vasya Ivanov',
        //     text: "Sell a car",
        //     car: 'BMW',
        //     created: 'yyyy-mm-dd hh:mm:ss'
        //   }
        // ],
        car: {
          id: '12',
          car: 'BMW',
          body: 'sedan',
          engine: 'gas',
          color: 'red',
          price: '10000',
          sold: 'true'
        }

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
        axios.get('http://localhost:9000/adv').then(result => {
          ;
        });
        this.state = 'loadedTable';
        console.log('showing cars...');
      },

      showCar() {
        // this.carId =id;
        this.state = 'showCar';
        console.log('showing car...');
      },
      add() {
        this.state = 'addCar';
        console.log('add an adv...');
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
