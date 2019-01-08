<template>


  <div class="car-info">
    <picture-loader
    :car="this.car"
    >
    </picture-loader>
    <div>
      <p> Advertisement #{{car.id}} created by {{carCreator.name}}</p>
      <article>{{car.text}}</article>
      <i>{{car.created}}</i>
    </div>
    <div>
      <p>Parameters:</p>
      <p>Car body type {{car.body}}</p>
      <p>Car color {{car.color}}</p>
      <p>Price {{car.price}}</p>
      <p :class='carSoldColorer()'>This car is {{isSold()}}</p>
    </div>
    <carousel :per-page="1"
              :mouse-drag="false" paginationPosition="top"
              :autoplay="true"
    >
      <slide>
        <img src="http://via.placeholder.com/640x360">
      </slide>
      <slide>
        <img src="http://via.placeholder.com/640x360">
      </slide>
      <slide>
        <img src="http://via.placeholder.com/640x360">
      </slide>
      <slide>
        <img src="http://via.placeholder.com/640x360">
      </slide>
    </carousel>

  </div>

</template>

<script>
  export default {
    props: ['car','carCreator'],
    data() {
      return {
      }
    },
    methods: {
      isSold() {
        if (this.car.sold == true) {
          return 'sold';
        } else {
          return 'able to buy';
        }
      },
      carSoldColorer() {
        if (this.car.sold == true) {
          return 'text-danger'
        } else {
          return 'text-primary'
        }
      },

    }


  }


</script>

<style scoped>
  .car-info {
    margin-bottom: 40px;
  }
</style>
