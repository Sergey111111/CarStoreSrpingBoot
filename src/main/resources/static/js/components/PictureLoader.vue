<template>
  <form class="form-row" enctype="multipart/form-data" action="http://localhost:9000/pic/upload" method="post" >
    <div class="custom-file">
      <input
        @change="onFileSelected"
        type="file" multiple class="custom-file-input" name="files" id="validatedCustomFile" required>
      <label class="custom-file-label" for="validatedCustomFile">Choose file...</label>
      <div class="invalid-feedback">Example invalid custom file feedback</div>
    </div>
    <input type="submit" class="btn btn-success"  />
    <!--<button-->
      <!--@click="onUpload"-->
      <!--class="btn btn-success">Add-->
    <!--</button>-->
  </form>
</template>

<script>
  export default {
    props: ['car'],
    name: "PictureLoader",
    methods: {
      onFileSelected(event) {
        this.selectedFile = event.target.files[0];
        console.log(event);
      },
      onUpload() {
        const fd = new FormData();
        fd.append('image', this.selectedFile, this.selectedFile.name);
        console.log(fd);
        let car = {
          name: this.name,
          color: this.color,
          body: this.body,
          price: this.price,
          text: this.text,
          user: this.user
        };
        axios.post('http://localhost:9000/pic/upload',
          fd).then(result => {
          console.log(result);
        })
      }
    }
  }
</script>

<style scoped>
  button {
    margin: 20px 0;
  }
</style>
