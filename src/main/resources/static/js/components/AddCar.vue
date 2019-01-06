<template>
  <div class="row">
    <div class="col-xs-5 col-md-3 col-lg-4 vcenter">
      <form class="form-row">

        <div>
          <label for="carname">Enter car name:</label>
          <input v-model="name" type="text" :class="'form-control '+ valid" id="carname" placeholder="Car" required>
          <!--<div v-if="valid == 'is-valid'" class="valid-feedback">-->
          <!--Looks good!-->
          <!--</div>-->
        </div>

        <!--<div>-->
        <!--<label for="carbody">Enter car body type:</label>-->
        <!--<input v-model="type" type="text" class="form-control" id="carbody" placeholder="Body" required>-->
        <!--&lt;!&ndash;<div v-if="isValid(name)=='valid'" class="valid-feedback">&ndash;&gt;-->
        <!--&lt;!&ndash;Looks good!&ndash;&gt;-->
        <!--&lt;!&ndash;</div>&ndash;&gt;-->
        <!--</div>-->

        <!--<div>-->
        <!--<label for="color">Enter car color:</label>-->
        <!--<input v-model="color" type="text" class="form-control " id="color" placeholder="Color" required>-->
        <!--&lt;!&ndash;<div v-if="isValid(name)=='valid'" class="valid-feedback">&ndash;&gt;-->
        <!--&lt;!&ndash;Looks good!&ndash;&gt;-->
        <!--&lt;!&ndash;</div>&ndash;&gt;-->
        <!--</div>-->

        <!--<div>-->
        <!--<label for="price">Enter car price:</label>-->
        <!--<input v-model="color" type="number" class="form-control" id="price" placeholder="Price" required>-->
        <!--&lt;!&ndash;<div v-if="isValid(name)=='valid'" class="valid-feedback">&ndash;&gt;-->
        <!--&lt;!&ndash;Looks good!&ndash;&gt;-->
        <!--&lt;!&ndash;</div>&ndash;&gt;-->
        <!--</div>-->

        <!--<div>-->
        <!--<label for="text">Write the description:</label>-->
        <!--<textarea v-model="text" class="form-control" id="text" placeholder="Description"-->
        <!--required></textarea>-->
        <!--&lt;!&ndash;<div v-if="isValid(name)=='valid'" class="valid-feedback">&ndash;&gt;-->
        <!--&lt;!&ndash;Looks good!&ndash;&gt;-->
        <!--&lt;!&ndash;</div>&ndash;&gt;-->
        <!--</div>-->

        <div class="custom-file">
          <label class="custom-file-label" for="validatedCustomFile">Choose file...</label>
          <input
            @change="onFileSelected"
            type="file" class="custom-file-input" id="validatedCustomFile" required>

          <div class="invalid-feedback">Example invalid custom file feedback</div>
        </div>
        <button
          @click="onUpload"
          class="btn btn-success">Add
        </button>
      </form>
    </div>
    <div class="col-xs-5 col-md-7 col-lg-8 vcenter">
      <h3>That's how the other users see your adv</h3>
      <p>Advertisement # created by {{user}}</p>
      <p>Car: {{ name }}</p>
      <p>Body type: {{ type }}</p>
      <p>Color: {{ color }}</p>
      <p>Price: {{ price }}</p>
      <p>Description: {{ text }}</p>
    </div>


  </div>
</template>

<script>

  import axios from 'axios';

  export default {
    props: ['user'],
    data() {
      return {
        valid: '',//if it's 'is-valid' then there will be a green tick in the corner
        name: '',
        type: '',
        color: '',
        price: '',
        text: '',
        selectedFile: null
      }
    },
    methods: {
      onFileSelected(event) {
        this.selectedFile = event.target.files[0];
        console.log(event);
      },
      onUpload() {
        const fd = new FormData();
        var car ={
          name:name
        }
        fd.append('image', this.selectedFile, this.selectedFile.name);
        axios.post('http://localhost:9000/adv', fd, car).then(result => {
          console.log(result);
        });
      }
    },
    isValidName() {
      if (name != null) {
        this.isValid = 'is-valid'
        return 'is-valid';
      }
    },
    createCar() {
      car:{
        name:'this.name'
      }

      axios.post('http://localhost:9000/car').then(result => {
        console.log(result);
      })
    }
  }
</script>

<style scoped>
  .custom-file {
    margin-top: 20px;
  }

  button {
    margin: 20px 0;
  }

</style>
