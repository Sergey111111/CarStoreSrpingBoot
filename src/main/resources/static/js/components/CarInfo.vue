<template>

  <div class="car-info">
    <div>
      <p> Advertisement #{{adv.id}} created by {{adv.user}}</p>
      <article>{{adv.text}}</article>
      <i>{{adv.created}}</i>
    </div>
    <div>
      {{car.id}}
      {{car.body}}
      {{car.color}}
      {{car.price}}
      {{car.sold}}
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
    props: ['car','adv']


  }


</script>

<style scoped>
  .car-info {
    margin-bottom: 40px;
  }
</style>
