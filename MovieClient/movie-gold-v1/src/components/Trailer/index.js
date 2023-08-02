import ReactPlayer from "react-player";
import "./index.css";
import React from 'react';
import {useParams} from "react-router-dom";

export default function Trailer() {
    const params = useParams();
    const key = params.ytTrailerId;
    const youtubeLink = `https://www.youtube.com/watch?v=${key}`;

    return (
        <div className={"react-player-container"}>
            {<ReactPlayer
                controls={true}
                playing={true}
                url={youtubeLink}
                width={"100%"}
                height={"100%"}
            />}
        </div>
    );
}
