import './App.css';
import api from './api/axiosConfig';
import {useEffect, useState} from "react";
import {Route, Routes} from "react-router-dom";
import Header from "./components/Header";
import Layout from "./components/Layout";
import Home from "./components/Home";
import Trailer from "./components/Trailer";
import Reviews from "./components/Reviews";

export default function App() {

    const [movies, setMovies] = useState([]);
    const [movie, setMovie] = useState([]);
    const [reviews, setReviews] = useState([]);


    const getMovies = async () => {
        try {
            const response = await api.get("/api/v1/movies");
            console.log(response.data);
            setMovies(response.data);
        } catch (err) {
            console.log(err);
        }
    }

    const getMovieData = async (movieId) => {
        try {
            const response = await api.get(`/api/v1/movies/${movieId}`);
            const singleMovie = response.data;
            setMovie(singleMovie);
            setReviews(singleMovie.reviewIds);
        } catch (err) {
            console.error(err)
        }
    }

    const [dbMovies, setDbMovies] = useState([]);
    const [dbMovie, setDbMovie] = useState([]);
    const [dbReviews, setDbReviews] = useState([]);

    const getDbMovies = async () => {
        try {
            const response = await api.get("/api/v1/movies/dbmap");
            console.log(response.data);
            setDbMovies(response.data);
        } catch (err) {
            console.log(err);
        }
    }

    const getDbMovieData = async (dbId) => {
        try {
            const response = await api.get(`/api/v1/movies/${dbId}`);
            const singleMovie = response.data;
            setDbMovie(singleMovie);
            setDbReviews(singleMovie.reviews);
        } catch (err) {
            console.error(err)
        }
    }
// const getMovies = async () => {
//     try {
//         const response = await fetch("/api/v1/movies");
//         if (response.ok) {
//             // console.log(response.data);
//             setMovies(response.data);
//         } else {
//             console.log(response.status)
//         }
//     } catch (err) {
//         console.log(err);
//     }
// }

    useEffect(() => {
        getMovies();
        getDbMovies()
    }, []);


    return (
        <div className="App">
            <Header/>
            <Routes>
                <Route path={"/"} element={<Layout/>}>
                    <Route path={"/"} element={<Home movies={movies}/>}></Route>
                    <Route path={"/dbHome"} element={<Home dbMovies={dbMovies}/>}></Route>
                    <Route path={"/Trailer/:ytTrailerId"} element={<Trailer/>}></Route>
                    <Route path={"/Reviews/:movieId"}
                           element={<Reviews getMovieData={getMovieData} movie={movie} reviews={reviews}
                                             setReviews={setReviews}/>}></Route>
                    <Route path={"/Reviews/:dbId"}
                           element={<Reviews getDbMovieData={getDbMovieData} dbMovie={dbMovie} dbReviews={dbReviews}
                                             setDbReviews={setDbReviews}/>}></Route>
                </Route>
            </Routes>
        </div>
    );
}