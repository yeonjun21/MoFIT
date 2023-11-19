<!-- <div class="d-grid gap-2 d-md-flex justify-content-md-end">
    <RouterLink :to="{ name: 'GalleryRegist' }" class="btn btn-primary" style="color: aliceblue;"> 등록 </RouterLink>
</div>
<div>
    <div v-for="gallery in galleryStore.galleryList" :key="gallery.index">
        <RouterLink :to="{ name: 'GalleryCommentList', params: { index: gallery.index } }">
            <div class="first-container">
                <p>{{ gallery.content }}</p>
                <div class="second-container">
                    <p>{{ gallery.nickname }}</p>
                    <p class="blank"> | </p>
                    <p>{{ gallery.date }}</p>
                </div>
                <img :src="gallery.img" alt="Gallery Image" />
            </div>
        </RouterLink>
    </div>
    <hr>
</div>


<div class="post">
    <div class="post-header">
      <div class="profile"></div>
      <span class="{{ gallery.nickname }}">ChanKim</span>
    </div>
    <div class="post-body">
        <img :src="gallery.img" alt="Gallery Image" />
    </div>
    <div class="post-content">
      <p><strong>{{ gallery.nickname }}</strong> {{ gallery.content }}</p>
      <p class="date">{{ gallery.date }}</p>
    </div>
</div>

.first-container {
    width: 100%;
    border-radius: 10px;
    padding: 13px;
    box-shadow: 0px 0px 5px rgb(170, 170, 170);
    margin: 20px 0px;
}

.first-container>p {
    margin-top: 10px;
    margin-left: 20px;
}

.second-container {
    display: flex;
    margin-left: 20px;
    padding-bottom: 0;
}

.second-container>p.blank {
    padding-left: 10px;
    padding-right: 10px;
}

a {
    text-decoration: none;
    color: black;
} -->



