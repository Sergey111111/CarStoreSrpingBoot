<template>

  <div align="left">
    <div class="d-flex justify-content-center">
      <div class="image_outer_container">
        <div class="image_inner_container">
          <div><img
            :src="profile.userpic"/>
          </div>
        </div>
      </div>
    </div>
    <div class="menu">
      <ul class="nav flex-column">
        <li class="nav-item">
          <a class="nav-link active" href="#">
            Profile
          </a>
        </li>
        <li class="nav-item">
          <a  class="nav-link" href="#"
             @click="$emit('add')"
          >Add new</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Messages</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#"
             @click="$emit('showAll')"
          >Top advs</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/logout"
             @click="$emit('logOut')"
          >Log out</a>
        </li>
      </ul>
    </div>
  </div>

</template>

<script>
export default {
  props:['profile'],
  data(){
    return {

    }
  }
}
</script>

<style scoped>
  html, body {
    height: 100%;
  }

  .container {
    height: 100%;
    align-content: center;
  }

  .image_outer_container {
    margin-top: auto;
    margin-bottom: auto;
    border-radius: 50%;
    position: relative;
  }

  .image_inner_container img {
    height: 150px;
    width: 150px;
    border: 5px solid white;
  }

  img {
    width: inherit;
    height: inherit;
  }

  .menu {
    align-content: center;
  }
</style>
