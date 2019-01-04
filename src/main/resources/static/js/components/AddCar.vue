<template>
  <div class="row">
    <div class="col-xs-5 col-md-3 col-lg-4 vcenter">
      <form class="form-row">

        <div>
          <label for="carname">Enter car name:</label>
          <input v-model="name" type="text" class="form-control is-valid" id="carname" placeholder="Car" required>
          <div v-if="validation=='valid'" class="valid-feedback">
            Looks good!
          </div>
        </div>

        <div>
          <label for="carbody">Enter car body type:</label>
          <input v-model="type" type="text" class="form-control is-valid" id="carbody" placeholder="Body" required>
          <div v-if="validation=='valid'" class="valid-feedback">
            Looks good!
          </div>
        </div>

        <div>
          <label for="color">Enter car color:</label>
          <input v-model="color" type="text" class="form-control " id="color" placeholder="Color" required>
          <div v-if="validation=='valid'" class="valid-feedback">
            Looks good!
          </div>
        </div>

        <div>
          <label for="price">Enter car price:</label>
          <input v-model="color" type="number" class="form-control is-valid" id="price" placeholder="Price" required>
          <div v-if="validation=='valid'" class="valid-feedback">
            Looks good!
          </div>
        </div>

        <div>
          <label for="text">Write the description:</label>
          <textarea v-model="text" class="form-control is-valid" id="text" placeholder="Description"
                    required></textarea>
          <div v-if="validation=='valid'" class="valid-feedback">
            Looks good!
          </div>
        </div>

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
        validation: 'invalid',
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
        const fd =new FormData();
        fd.append('image',this.selectedFile, this.selectedFile.name);
        axios.get('/addcar',fd).then(result =>{
          console.log(result);
        });
      }
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
